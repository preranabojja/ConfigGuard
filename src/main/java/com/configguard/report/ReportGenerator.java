package com.configguard.report;

import com.configguard.validator.ValidationResult;

import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    public static void generate(ValidationResult result,
                                String filePath)
            throws IOException {

        FileWriter writer = new FileWriter(filePath);

        writer.write("CONFIGGUARD VALIDATION REPORT\n");
        writer.write("============================\n\n");

        writer.write("Valid: "
                + result.isValid()
                + "\n\n");

        writer.write("Errors:\n");

        for (String error : result.getErrors()) {
            writer.write("- " + error + "\n");
        }

        writer.write("\nWarnings:\n");

        for (String warning : result.getWarnings()) {
            writer.write("- " + warning + "\n");
        }

        writer.close();
    }
}
