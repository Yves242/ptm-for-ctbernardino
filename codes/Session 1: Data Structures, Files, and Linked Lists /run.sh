#!/bin/bash

# This helper script is authored and created by John Yves Baltazar,
# made with the assistance of the famous AI tool ChatGPT,
# just to make navigation of peer tutor materials easier for you.

clear

# Flag to track if the script has already run
script_run=false

# main function
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
    
    # Populate choices array with base filenames
    while IFS= read -r -d '' file; do
        base_filename=$(basename "$file")
        choices+=("$base_filename")
    done < <(find . -type f -name "*.c" -print0)
    
    # add last choice for quitting/exiting
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

# function that compiles and runs a c file 
compile_and_run() {
    
    # reference for the chosen c file
    c_file="$1"

    # try compile
    gcc "$c_file" -o a.out

    # if gcc returned 0
    if [ $? -eq 0 ]; then
                
        # print notifications
        echo ""
        echo $'————————————————————————————————————'
        echo $'Dynamic compilation done. Running...'
        echo $'————————————————————————————————————\n'

        # execute the program
        ./a.out

        # # remove the compiled program
        # rm a.out

        # print it's finished
        echo $'\n————————————————————————————————————'
        echo $'\nThe program has finished running.\n'

    # if gcc returned error
    else
        echo $'\n\nCompilation failed.'
    fi
}

# Main script
select_file
