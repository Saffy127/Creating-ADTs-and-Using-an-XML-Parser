package main;
import implementations.*;

import java.io.*;

public class XMLParser {

    private MyStack<String> tagStack;
    private MyArrayList<String> errorList;
    private boolean rootTagFound = false;

    public XMLParser() {
        tagStack = new MyStack<>();
        errorList = new MyArrayList<>();
    }

    public void parse(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String trimmedLine = line.trim();

                // Ignore processing instructions
                if (trimmedLine.startsWith("<?xml")) continue;

                if (trimmedLine.endsWith("/>")) continue; // Handling self-closing tags

                if (trimmedLine.startsWith("</")) { // Closing tag
                    String closingTag = trimmedLine.substring(2, trimmedLine.length() - 1);

                    if (tagStack.isEmpty() || !tagStack.peek().equals(closingTag)) {
                        errorList.add("Error at line " + lineNumber + ": Mismatched or extra closing tag.");
                    } else {
                        tagStack.pop();
                    }
                } else if (trimmedLine.startsWith("<")) { // Opening tag
                    String openingTag = trimmedLine.substring(1, trimmedLine.indexOf(">"));

                    if (!rootTagFound) {
                        rootTagFound = true;
                    } else if (tagStack.isEmpty()) {
                        errorList.add("Error: Multiple root tags found.");
                        return; // End the parsing as the XML structure is invalid.
                    }

                    tagStack.push(openingTag);
                }
            }

            if (tagStack.size() > 1) {
                errorList.add("Error: Missing closing tag for: " + tagStack.pop());
            } else if (tagStack.isEmpty() && !rootTagFound) {
                errorList.add("Error: No root tag found.");
            }
        }
    }

    public void displayErrors() {
        for (String error : errorList) {
            System.out.println(error);
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the path to the XML file.");
            return;
        }

        XMLParser parser = new XMLParser();

        try {
            parser.parse(args[0]);
            parser.displayErrors();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
