## Design Tic-Tac-Toe

### What is this?
> A game that has a board with N*N cells and N-1 Players, where they play in a round-robin fashion and lay their symbols on board during their turn while making their symbols come in a row and blocking other player symbols from forming the winning pattern. A player wins the game when their symbol gets aligned in a single row/column/diagonal at any point of time.

### Type of System
> Command Line & Interactive (no data persistence) Application

### Requirements
> 1. A board contains N*N cells, where N = [3,Infinity]
> 2. Players in a single game are (N-1)
> 3. A cell contains a unique symbol of the player
> 4. All symbols of the players in a game must be unique
> 5. Who starts the game? A list of Players is randomized before game starts, and they play in a circular fashion in an order.
> 6. A game contains global "undo" functionality, where anybody can undo a moves.
> 7. No play, pause, resume functions
> 8. When game ends? When one wins the game & When no one wins
> 9. Who will win? A player who gets their symbols in a single row/column/diagonal at any point of the game.
> 10. No timers, tournaments, leaderboard
> 11. Game can have a bot (at most 1)