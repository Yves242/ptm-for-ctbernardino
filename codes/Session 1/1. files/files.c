#include <stdio.h>
#include <string.h>


/// @brief Function that reads and prints the contents of a file.
void readFromFileUsing_fgetc() {
    FILE *fp;
    char ch;

    // Open the file in read mode
    fp = fopen("read-this-file.txt", "r");
    if (fp == NULL) {
        printf("Error opening file for reading.\nDoes the file exist?\n");
        return;
    }

    // Read characters from the file and print them
    printf("\nAccessing contents of file using fgetc(): \n");
    int line_counter = 0;
    while ((ch = fgetc(fp)) != EOF) {   // fgetc() gets 1 character each time in the while loop
        if (ch == '\n') {
            printf("character '\\n' (iteration %i)  (newline)\n", ++line_counter);
        } else {
            printf("character '%c'  (iteration %i)\n", ch, ++line_counter);
        }
    }

    // Close the file
    fclose(fp);
}

/// @brief Function that reads and prints the contents of a file using fgets().
void readFromFileUsing_fgets() {

    // max character count you want to get from file.
    int max_char_count = 100;

    // variable declarations
    FILE *fp;
    char line[max_char_count];

    // Open the file in read mode
    fp = fopen("read-this-file.txt", "r");
    if (fp == NULL) {
        printf("Error opening file for reading.\nDoes the file exist?\n");
        return;
    }

    // Read lines from the file and print them
    printf("\nAccessing contents of file using fgets():\n\n");

    // count for how many iterations
    int fgets_counter = 0;
    while (fgets(line, max_char_count, fp) != NULL) {
        printf("\nfgets() [iteration %i]. Got string below:\n'%s'\nIt had %li characters.\n\n", ++fgets_counter, line, strlen(line));  // Print the read line
    }

    // Close the file
    fclose(fp);
}

/// @brief Function that writes text to a file.
void writeToFile() {
    FILE *fp;
    char text[] = "This is what we will place to the file.";

    // Open the file in write mode
    fp = fopen("new-file.txt", "w");
    if (fp == NULL) {
        printf("Error opening file for writing.\n");
        return;
    }

    // Write text to the file
    fprintf(fp, "%s\n", text);

    // Close the file
    fclose(fp);
}

/// @brief Function that writes text to a file.
void appendToFile() {
    FILE *fp;
    char text[] = "This is what we will place to the file.";

    // Open the file in write mode
    fp = fopen("new-file.txt", "a");
    if (fp == NULL) {
        printf("Error opening file for writing.\n");
        return;
    }

    // Write text to the file
    fprintf(fp, "%s\n", text);

    // Close the file
    fclose(fp);
}

/// @brief Function that removes a file. Di ata tinopic but yeah just for information.
void removeFile() {
    char filename[] = "new-file.txt";

    // Attempt to delete the file
    if (remove(filename) == 0) {
        printf("File '%s' deleted successfully.\n", filename);
    } else {
        printf("\nError deleting file '%s'.\nDoes it actually exist?\n", filename);
    }
}


#include <dirent.h> 

int main(void) {
  DIR *d;
  struct dirent *dir;
  d = opendir(".");
  if (d) {
    while ((dir = readdir(d)) != NULL) {
      printf("%s\n", dir->d_name);
    }
    closedir(d);
  }
  return(0);
}

void xmain() {

    // variable declarations
    char choice[10];

    // loop
    while (1) {

        // Menu
        printf("\nWhat would you like to do:\n");
        printf("1. Read from file using fgetc\n");
        printf("2. Read from file using fgets\n");
        printf("3. Write to file\n");
        printf("4. Delete file\n");
        printf("5. Append to file\n");
        printf("0. Exit\n");
        printf("\nEnter choice: ");
        scanf("%s", choice);

        // Perform action based on user's choice
        switch (choice[0]) {
            case '1':
                readFromFileUsing_fgetc();
                break;
            case '2':
                readFromFileUsing_fgets();
                break;
            case '3':
                writeToFile();
                break;
            case '4':
                removeFile();
                break;
            case '5':
                appendToFile();
                break;
            case '0':
            case '6':
                return;
            default:
                printf("Invalid choice. Try again.\n");
        }

    }

}
