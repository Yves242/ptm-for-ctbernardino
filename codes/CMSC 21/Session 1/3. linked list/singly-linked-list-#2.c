#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Structure for a song
typedef struct Song {
    char title[100];   // Title of the song
    char artist[100];  // Artist of the song
    float duration;    // Duration of the song in minutes
    int year;          // Release year of the song
    struct Song *next; // Pointer to the next song in the playlist
} SONG;

// Function prototypes
SONG* createSong(const char *title, const char *artist, float duration, int year);
void printPlaylist(SONG *head);
void deletePlaylist(SONG *head);
void appendSong(SONG **head, SONG *newSong);


// main function
void main() {

    // Create a playlist
    SONG *head = NULL;

    // Create songs
    SONG *song1 = createSong("Bohemian Rhapsody", "Queen", 5.92, 1975);
    SONG *song2 = createSong("Stairway to Heaven", "Led Zeppelin", 8.03, 1971);
    SONG *song3 = createSong("Hotel California", "Eagles", 6.30, 1977);
    SONG *song4 = createSong("Imagine", "John Lennon", 3.03, 1971);

    // Add songs to the playlist
    appendSong(&head, song1);
    appendSong(&head, song2);
    appendSong(&head, song3);
    appendSong(&head, song4);

    // Print the playlist
    printf("Current Playlist:\n\n");
    printPlaylist(head);

    // Delete the playlist to free memory
    deletePlaylist(head);
}

/// @brief Function to create a new song.
/// @param title Title of the song.
/// @param artist Artist of the song.
/// @param duration Duration of the song in minutes.
/// @param year Release year of the song.
/// @return Pointer to the newly created song.
SONG* createSong(const char *new_title, const char *new_artist, float new_duration, int new_year) {
    
    // Allocate memory for the new song
    SONG *newSongInstance = (SONG*) malloc(sizeof(SONG));
    if (newSongInstance == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(1);
    }

    // Set the song details
    strcpy(newSongInstance->title, new_title);
    strcpy(newSongInstance->artist, new_artist);
    newSongInstance->duration = new_duration;
    newSongInstance->year = new_year;
    newSongInstance->next = NULL;

    return newSongInstance;
}

// Function to append a new song to the end of the playlist
void appendSong(SONG **head, SONG *newSong) {
    
    // If playlist is empty, set new song as the head
    if (*head == NULL) {
        *head = newSong;
        return;
    }

    // Find the last song in the playlist
    SONG *lastSong = *head;
    while (lastSong->next != NULL) {
        lastSong = lastSong->next;
    }

    // Append the new song to the end
    lastSong->next = newSong;
}

// Function to print the playlist
void printPlaylist(SONG *head) {
    
    
    // variable declarations
    SONG *current = head;
    int count = 1;

    // Traverse the playlist and print each song
    while (current != NULL) {
        printf("Song #%d:\n", count);
        printf("   Title: %s\n", current->title);
        printf("   Artist: %s\n", current->artist);
        printf("   Duration: %.2f minutes\n", current->duration);
        printf("   Year: %d\n\n", current->year);
        
        current = current->next;
        count++;
    }
}

// Function to delete the entire playlist
void deletePlaylist(SONG *head) {
    
    // variable declarations
    SONG *current = head;
    SONG *nextSong;

    // Traverse the playlist and free memory for each song
    while (current != NULL) {
        nextSong = current->next;
        free(current);
        current = nextSong;
    }
}
