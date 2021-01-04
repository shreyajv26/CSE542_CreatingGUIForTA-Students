# CSE542_CreatingGUIForTA-Students
CSE 542 - Software Engineering Concepts


Java source code for the GUI program the team wrote. Your program should contain all
of the GUI functionality the program requires. It should display the current queue state
and include the option for users to add an entry to the queue, remove an entry from
the queue, and "pause" and "unpause" individual entries.

• When adding an entry, your program should require the user to enter their name,
email address, and a "session password". Entries should always be added to the end
of the queue. Because this is only a prototype, you can assume that the email address
is valid and is not already on the queue.

• When removing an entry, your program should require the user enter their "session
password". Because this is only a prototype, always assume that the "session
password" is correct. For this early phase, advance all lower entries, including
"paused" entries, when an entry is removed.

• Allow the user to "pause" and "unpause" an entry. When this happens, your
program should require the user enter their "session password". Because this is only
a prototype, always assume that the "session password" is correct. Your program
must clearly identify which entries in the queue are currently "paused".

• Your program should begin with a random number of entries in the queue (the
number of entries should be between 0 – 4). Each entry will need to have a name and
“e-mail address" and be "unpaused". You should use a preset list of names and email
addresses to populate these entries.
