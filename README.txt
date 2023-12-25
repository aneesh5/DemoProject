GUIDANCE & Implementation: 
Added below APIs

1. /entercandidate - The API entercandidate shall take a name as a parameter and save that into a table with a count(vote count) initialized to 0.
2. /castVote - The API castvote shall take a name as a parameter and increment the vote count and return it.
3. /countVote - The API countvote shall take a name as a parameter and should return the latest vote count.
4. /listVote - The API listvote shall return all names and votecounts in JSON format
5. /getWinner - The API getwinner shall return the name of the candidate who got the highest number of votes.


