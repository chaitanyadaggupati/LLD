class User:
    
    def __init__(self, user_id, name, email, phone):
        self.user_id = user_id
        self.name = name
        self.email = email
        self.phone = phone
        self.payment_from = {}
        self.payment_to = {}
    
    def set_payment_from(self, user, amount):
        if user not in self.payment_from:
            self.payment_from[user] = amount
        else:
            self.payment_from[user] += amount
        
    def set_payment_to(self, user, amount):
        if user not in self.payment_to:
            self.payment_to[user] = amount
        else:
            self.payment_to[user] += amount