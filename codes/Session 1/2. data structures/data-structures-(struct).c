#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define TRUE 1
#define FALSE 0

// Define the structure for a Song
struct Song {
    char title[100];   // Stores the title of the song (up to 100 characters)
    char artist[100];  // Stores the artist of the song (up to 100 characters)
    float duration;    // Stores the duration of the song in minutes
    int year;          // Stores the release year of the song
};

void main() {

    // determines which part to print
    int printNow = 0;




    /* PART 1: You can make variable of a data structure like this */

    // Create a Song object named mySong
    struct Song mySong;

    // Initialize values of mySong
    strcpy(mySong.title, "Bohemian Rhapsody");  // Set title
    strcpy(mySong.artist, "Queen");             // Set artist 
    mySong.duration = 5.92;                     // Set duration of song to 5 mins and 55 sec
    mySong.year = 1975;                         // Set release year of the song to 1975



    // // uncomment this when you want to print up to here
    // printNow = TRUE;

    // print appropriately
    if (printNow) {

        // Print details of the song
        printf("   Song Title: %s\n", mySong.title);
        printf("  Song Artist: %s\n", mySong.artist);
        printf("Song Duration: %.2f minutes\n", mySong.duration);
        printf("Year Released: %d\n\n", mySong.year);

        exit(0);
    }




    /* PART 2.1: You can make array of data structures like this */

    // Create array of Song objects
    struct Song playlist[3];

    // Initialize values for each song the playlist
    strcpy(playlist[0].title, "Stairway to Heaven");
    strcpy(playlist[0].artist, "Led Zeppelin");
    playlist[0].duration = 8.03;
    playlist[0].year = 1971;

    // Initialize values for each song the playlist
    strcpy(playlist[1].title, "Hotel California");
    strcpy(playlist[1].artist, "Eagles");
    playlist[1].duration = 6.30;
    playlist[1].year = 1977;

    // Initialize values for each song the playlist
    strcpy(playlist[2].title, "Imagine");
    strcpy(playlist[2].artist, "John Lennon");
    playlist[2].duration = 3.03;
    playlist[2].year = 1971;


    // // uncomment this if you want to print here
    // printNow = TRUE;

    // print appropriately
    if (printNow) {

        // Print details of each song in the playlist
        printf("Songs under current playlist:\n");
        for (int i = 0; i < 3; i++) {
            printf("\nSong #%i:\n", i);
            printf("       Song Title: %s\n", playlist[i].title);
            printf("      Song Artist: %s\n", playlist[i].artist);
            printf("    Song Duration: %.2f minutes\n", playlist[i].duration);
            printf("    Year Released: %d\n", playlist[i].year);
        }

        exit(0);
    }




    /* PART 2.2: You can directly modify array values doing this format */
    playlist[0] = mySong;

    // print appropriately
    if (printNow) {

        // Print details of each song in the playlist
        printf("Songs after modifying first song playlist:\n");
        for (int i = 0; i < 3; i++) {
            printf("\nSong #%i:\n", i);
            printf("       Song Title: %s\n", playlist[i].title);
            printf("      Song Artist: %s\n", playlist[i].artist);
            printf("    Song Duration: %.2f minutes\n", playlist[i].duration);
            printf("    Year Released: %d\n", playlist[i].year);
        }

        exit(0);
    }



    // // uncomment this when you want to print up to here
    // printNow = TRUE;

    /* PART 2.3: You can directly modify details like this */
    strcpy(playlist[2].title, "");  // kapag string, need strcpy()
    playlist[2].year = 100000;      // kapag int or float, kahit direct value na
    playlist[2].duration = 1234.5;

    // print appropriately
    if (printNow) {

        // Print details of each song in the playlist
        printf("Songs after modifying second song playlist:\n");
        for (int i = 0; i < 3; i++) {
            printf("\nSong #%i:\n", i);
            printf("       Song Title: %s\n", playlist[i].title);
            printf("      Song Artist: %s\n", playlist[i].artist);
            printf("    Song Duration: %.2f minutes\n", playlist[i].duration);
            printf("    Year Released: %d\n", playlist[i].year);
        }

        exit(0);
    }
    
    printf("Oooh, you forgot to uncomment which \npart you want to print out. \nUncomment one line below:\n\n[line 37]  // printNow = TRUE;\n[line 79]  // printNow = TRUE;\n[line 122] // printNow = TRUE;\n\n");
}
