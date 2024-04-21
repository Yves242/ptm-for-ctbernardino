#!/bin/bash

# This helper script is authored and created by John Yves Baltazar,
# made with the assistance of the famous AI tool ChatGPT,
# just to make navigation of peer tutor materials easier for you.

# clear the screen
clear

# Flag to track if the script has already run
script_run=false

select_file() {
    # Check if the script has already run
    if [ "$script_run" = true ]; then
        echo "Script has already been executed. Exiting..."
        exit
    fi

    # Set the flag to true to indicate that the script has run
    script_run=true

    # notification print-out
    echo $'\nSelect a C file to run:'

    # proceed to ask for choice
    PS3=$'\nOption: '
    
    # put choices here
    choices=()
    
    # Populate choices array with base filenames sorted alphabetically
    while IFS= read -r -d '' file; do
        base_filename=$(basename "$file")
        choices+=("$base_filename")
    done < <(find . -type f -name "*.c" -print0 | sort -z)

    choices+=("Quit/Exit")

    # switch-case for choice
    select choice in "${choices[@]}"; do
        case $REPLY in

            # if quit option
            ${#choices[@]})
                echo $'\nExiting...'
                exit;;

            # if anything other than quit option
            *)

                # if invalid
                if [ -z "$choice" ]; then
                    echo "Invalid choice. Please try again."
                
                # if valid
                else
                    # Get the full path for compilation
                    c_file=$(find . -type f -name "$choice" -print -quit)
                    compile_and_run "$c_file"
                    break  # Exit the loop after making a selection
                fi;;
        esac
    done
}


compile_and_run() {
    # Reference for the chosen C file
    c_file="$1"

    # Save the current directory
    original_dir=$(pwd)

    # Enclose the file path in double quotes to handle spaces and special characters
    c_file="$c_file"

    # Extract the directory path of the C file
    c_dir=$(dirname "$c_file")

    # Change directory to the location of the C file
    cd "$c_dir" || { echo "Error: Directory $c_dir does not exist."; exit 1; }

    # Compile the C file and create the executable file
    gcc -o "$(basename "$c_file").out" "$(basename "$c_file")"

    # Check if compilation was successful
    if [ $? -eq 0 ]; then
        echo $'\n—————————————————————————————————————————————————'
        echo $'Compilation successful. Running program.'
        echo $'—————————————————————————————————————————————————\n'

        # Execute the compiled file
        ./$(basename "$c_file").out

        # Print a message indicating program execution is finished
        echo $'\n\n—————————————————————————————————————————————————'
        echo $'\nThe program has finished running.\n'

        # Return to the original directory
        cd "$original_dir"

    else
        # Print an error message if compilation failed
        echo $'\n\nCompilation failed.'
    fi
}


# Main script
select_file
