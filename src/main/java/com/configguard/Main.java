package com.configguard;

import com.configguard.model.Config;
import com.configguard.parser.ConfigParser;
import com.configguard.validator.ConfigValidator;
import com.configguard.validator.ValidationResult;
import com.configguard.report.ReportGenerator;

public class Main {

    public static void main(String[] args) {

        try {

            String filePath = args.length > 0
        ? args[0]
        : "configs/dev.json";

Config config =
        ConfigParser.parse(filePath);

            ValidationResult result =
                    ConfigValidator.validate(config);

            System.out.println("\nVALIDATION REPORT");
            System.out.println("-----------------");
            System.out.println("Valid: " + result.isValid());

            System.out.println("\nErrors:");
            result.getErrors().forEach(System.out::println);

            System.out.println("\nWarnings:");
            result.getWarnings().forEach(System.out::println);

            // ADD THIS PART HERE
            ReportGenerator.generate(
                    result,
                    "reports/report.txt");

            System.out.println(
                    "\nReport saved to reports/report.txt");

        }
        catch (Exception e) {

            System.out.println("Error reading config file");
            e.printStackTrace();

        }
    }
}