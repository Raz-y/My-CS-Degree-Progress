# Assembler Project

## Overview

This assembler is the final project for the 2024 Semester A System Programming Lab.

- **Macro Processing:** Expands macros within the assembly files.
- **First Pass:** Builds a symbol table and determines memory addresses.
- **Second Pass:** Uses the symbol table and memory addresses to generate machine code.

## Requirements

The assembler is implemented in C and is intended to be run on Unix/Linux environments.

- Each input file must have a `.as` extension.

## Usage

To run the assembler, use the following command format. Exclude the `.as` extension from the filenames when passing them as arguments:

./assembler <file1>, <file2>

For example, if your assembly file is named `program.as`, you would run:

./assembler program

## Output
The assembler generates several types of files depending on the contents of the input files:
- `.ob` - Object code file containing the machine code.
- `.ent` - Entry file listing all entry labels along with their addresses.
- `.ext` - External file listing all external labels used in the assembly file.
- `.am` - Error file (if applicable) detailing any issues found during the assembly process.
Error messages and line numbers related to syntax or semantic issues are outputted following the `.am` file format.

## Testing Guidelines
- **File Preparation:** Ensure all test files have the correct `.as` extension and do not include this extension in the command line argument.
- **Expected Outputs:** After running the assembler, check the corresponding output files for accuracy. Verify that the `.ob`, `.ent`, `.ext`, and `.am` files contain the expected results.
- **Error Handling:** Examine `.am` files for any error messages. Ensure that the errors reported are relevant and accurate according to the issues in the `.as` file.
- **Multiple Files:** Test with multiple files in a single run to ensure the assembler handles multiple inputs correctly.

## Troubleshooting
If you encounter issues such as no output files being created or unexpected terminations, check the following:
- Ensure that the permissions on the directory where you are running the assembler allow file creation.
- Verify that the input files are formatted correctly and adhere to the expected assembly language syntax.
