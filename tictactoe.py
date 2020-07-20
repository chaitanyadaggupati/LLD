class TicTacToe(object):
    def __init__(self, n):
        self.n = n
        self.row_sum = 0
        self.col_sum = 0
        self.diag_sum = 0
        self.rev_diag_sum = 0
        self.board = [['']*n for _ in range(n)]
        self.winner = None

    def move(self, player, row, col):
        if row<0 or col<0 or row>=self.n or col>=self.n:
            return
        if self.board[row][col] !=0:
            return
        if player!=0 or player!=1:
            return
        if self.row_sum==abs(self.n) or self.col_sum==abs(self.n) \
            or self.diag_sum==abs(self.n) or self.rev_diag_sum==abs(self.n):
            return player
        player = -1 if player==0 else 1
        self.board[row][col]=player
        self.row_sum += player
        self.col_sum += player
        if row==col:
            self.diag_sum += player
        if row==self.n-col+1:
            self.rev_diag_sum += player
        if self.row_sum==abs(self.n) or self.col_sum==abs(self.n) \
            or self.diag_sum==abs(self.n) or self.rev_diag_sum==abs(self.n):
            self.winner = player
        return self.get_winner()

    def get_winner(self):
        return self.winner

