package com.aixohub.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BeijingSalaryMonthlyCalculator {
    // 北京社保缴费基数
    private static final BigDecimal MIN_SOCIAL_BASE = new BigDecimal("6326");
    private static final BigDecimal MAX_SOCIAL_BASE = new BigDecimal("33891");

    // 社保比例
    private static final BigDecimal PENSION_RATE = new BigDecimal("0.08");
    private static final BigDecimal MEDICAL_RATE = new BigDecimal("0.02");
    private static final BigDecimal MEDICAL_EXTRA = new BigDecimal("3");
    private static final BigDecimal UNEMPLOYMENT_RATE = new BigDecimal("0.002");
    private static final BigDecimal HOUSING_FUND_RATE = new BigDecimal("0.12");
    private static final BigDecimal TAX_THRESHOLD = new BigDecimal("5000");

    // 累计税率和速算扣除数
    private static final BigDecimal[][] TAX_RATES = {
            {new BigDecimal("36000"), new BigDecimal("0.03"), BigDecimal.ZERO},
            {new BigDecimal("144000"), new BigDecimal("0.10"), new BigDecimal("2520")},
            {new BigDecimal("300000"), new BigDecimal("0.20"), new BigDecimal("16920")},
            {new BigDecimal("420000"), new BigDecimal("0.25"), new BigDecimal("31920")},
            {new BigDecimal("660000"), new BigDecimal("0.30"), new BigDecimal("52920")},
            {new BigDecimal("960000"), new BigDecimal("0.35"), new BigDecimal("85920")},
            {null, new BigDecimal("0.45"), new BigDecimal("181920")}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的年薪（元）：");
        BigDecimal monthlySalary = new BigDecimal(scanner.nextLine());
        scanner.close();

        System.out.println("\n=== 北京工资计算明细（按月展示）===");
        System.out.printf("年薪：%,.2f 元\n", monthlySalary);

        calculateMonthlySalaries(monthlySalary);
    }

    private static void calculateMonthlySalaries(BigDecimal monthlySalary) {
        DecimalFormat df = new DecimalFormat("#,##0.00");


        BigDecimal socialBase = monthlySalary.min(MAX_SOCIAL_BASE).max(MIN_SOCIAL_BASE);
        BigDecimal housingFundBase = socialBase;

        // 每月固定扣除项
        BigDecimal pension = socialBase.multiply(PENSION_RATE).setScale(2, RoundingMode.HALF_UP);
        BigDecimal medical = socialBase.multiply(MEDICAL_RATE).add(MEDICAL_EXTRA).setScale(2, RoundingMode.HALF_UP);
        BigDecimal unemployment = socialBase.multiply(UNEMPLOYMENT_RATE).setScale(2, RoundingMode.HALF_UP);
        BigDecimal housingFund = housingFundBase.multiply(HOUSING_FUND_RATE).setScale(2, RoundingMode.HALF_UP);
        BigDecimal monthlyDeduction = pension.add(medical).add(unemployment).add(housingFund);

        System.out.println("\n【每月五险一金个人缴纳部分】");
        System.out.println("养老保险(8%)： " + df.format(pension) + " 元/月");
        System.out.println("医疗保险(2%+3)： " + df.format(medical) + " 元/月");
        System.out.println("失业保险(0.2%)： " + df.format(unemployment) + " 元/月");
        System.out.println("住房公积金(12%)： " + df.format(housingFund) + " 元/月");
        System.out.println("五险一金个人总计： " + df.format(monthlyDeduction) + " 元/月");

        // 累计应纳税所得额和已缴税额
        BigDecimal accumulatedTaxableIncome = BigDecimal.ZERO;
        BigDecimal accumulatedTax = BigDecimal.ZERO;

        System.out.println("\n【月度个人所得税明细】");
        System.out.println("月份\t税前工资\t应纳税所得额\t累计应纳税所得额\t税率\t速算扣除数\t本月个税\t累计个税\t税后工资");

        for (int month = 1; month <= 12; month++) {
            BigDecimal taxableIncome = monthlySalary.subtract(monthlyDeduction).subtract(TAX_THRESHOLD);
            if (taxableIncome.compareTo(BigDecimal.ZERO) < 0) {
                taxableIncome = BigDecimal.ZERO;
            }

            accumulatedTaxableIncome = accumulatedTaxableIncome.add(taxableIncome);

            // 计算累计应纳税额
            BigDecimal accumulatedTaxAmount = calculateAccumulatedTax(accumulatedTaxableIncome);
            BigDecimal monthlyTax = accumulatedTaxAmount.subtract(accumulatedTax);
            accumulatedTax = accumulatedTaxAmount;

            BigDecimal netSalary = monthlySalary.subtract(monthlyDeduction).subtract(monthlyTax);

            // 获取当前税率和速算扣除数
            Object[] rateInfo = getCurrentTaxRate(accumulatedTaxableIncome);
            BigDecimal rate = (BigDecimal) rateInfo[0];
            BigDecimal quickDeduction = (BigDecimal) rateInfo[1];

            System.out.printf("%d月\t%s\t%s\t%s\t%.0f%%\t%s\t%s\t%s\t%s\n",
                    month,
                    df.format(monthlySalary),
                    df.format(taxableIncome),
                    df.format(accumulatedTaxableIncome),
                    rate.multiply(new BigDecimal("100")),
                    df.format(quickDeduction),
                    df.format(monthlyTax),
                    df.format(accumulatedTax),
                    df.format(netSalary));
        }
    }

    private static BigDecimal calculateAccumulatedTax(BigDecimal accumulatedTaxableIncome) {
        for (BigDecimal[] bracket : TAX_RATES) {
            if (bracket[0] == null || accumulatedTaxableIncome.compareTo(bracket[0]) <= 0) {
                return accumulatedTaxableIncome.multiply(bracket[1]).subtract(bracket[2])
                        .setScale(2, RoundingMode.HALF_UP);
            }
        }
        return BigDecimal.ZERO;
    }

    private static Object[] getCurrentTaxRate(BigDecimal accumulatedTaxableIncome) {
        for (BigDecimal[] bracket : TAX_RATES) {
            if (bracket[0] == null || accumulatedTaxableIncome.compareTo(bracket[0]) <= 0) {
                return new Object[]{bracket[1], bracket[2]};
            }
        }
        return new Object[]{BigDecimal.ZERO, BigDecimal.ZERO};
    }
}