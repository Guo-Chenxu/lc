package main

func solve(board [][]byte) {
	var dfs func(x, y int)
	dfs = func(x, y int) {
		if x < 0 || x >= len(board) || y < 0 || y >= len(board[0]) {
			return
		}

		if board[x][y] == 'O' {
			board[x][y] = '1'
			dfs(x-1, y)
			dfs(x+1, y)
			dfs(x, y-1)
			dfs(x, y+1)
		}
	}

	m, n := len(board), len(board[0])
	for i := 0; i < m; i++ {
		if board[i][0] == 'O' {
			dfs(i, 0)
		}
		if board[i][n-1] == 'O' {
			dfs(i, n-1)
		}
	}
	for i := 0; i < n; i++ {
		if board[0][i] == 'O' {
			dfs(0, i)
		}
		if board[m-1][i] == 'O' {
			dfs(m-1, i)
		}
	}

	for i, g := range board {
		for j := range g {
			if board[i][j] == '1' {
				board[i][j] = 'O'
			} else {
				board[i][j] = 'X'
			}
		}
	}
}
