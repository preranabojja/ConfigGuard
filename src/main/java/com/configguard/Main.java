package com.configguard;

import com.configguard.model.Config;
import com.configguard.parser.ConfigParser;
import com.configguard.report.ReportGenerator;
import com.configguard.validator.ConfigValidator;
import com.configguard.validator.ValidationResult;

public class Main {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: <command> <config-file>");
            System.out.println("Commands:");
            System.out.println("  validate <config-file>");
            System.out.println("  summary <config-file>");
            return;
        }

        String command = args[0];
        String filePath = args[1];

        // SUMMARY COMMAND
        if (command.equals("summary")) {

            try {
                Config config = ConfigParser.parse(filePath);

                System.out.println("CONFIG SUMMARY");
                System.out.println("--------------");
                System.out.println("Server: " + config.getServer());
                System.out.println("Port: " + config.getPort());
                System.out.println("Timeout: " + config.getTimeout());

            } catch (Exception e) {
                System.out.println("Error reading configuration file.");
                e.printStackTrace();
            }

            return;
        }

        // VALIDATE COMMAND
        if (!command.equals("validate")) {
            System.out.println("Unknown command: " + command);
            return;
        }

        try {

            Config config = ConfigParser.parse(filePath);

            ValidationResult result =
                    ConfigValidator.validate(config);

            System.out.println("\nVALIDATION REPORT");
            System.out.println("-----------------");
            System.out.println("Valid: " + result.isValid());

            System.out.println("\nErrors:");
            for (String error : result.getErrors()) {
                System.out.println(error);
            }

            System.out.println("\nWarnings:");
            for (String warning : result.getWarnings()) {
                System.out.println(warning);
            }

            String reportFile =
                    "reports/report_"
                    + System.currentTimeMillis()
                    + ".txt";

            ReportGenerator.generate(
                    result,
                    reportFile);

            System.out.println(
                    "\nReport saved to " + reportFile);

        } catch (Exception e) {
            System.out.println("Error validating configuration.");
            e.printStackTrace();
        }
    }
}