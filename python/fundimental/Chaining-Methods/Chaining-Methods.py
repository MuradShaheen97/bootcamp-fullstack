class User:
    def __init__(self, name, balance=0):
        self.name = name
        self.account_balance = balance

    def make_deposit(self, amount):
        self.account_balance += amount
        return self

    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self

    def display_user_balance(self):
        print(f"User: {self.name}, Balance: ${self.account_balance}")
        return self

    def transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
        return self


# Create users
user1 = User("Guido van Rossum", 100)
user2 = User("Michael Jordan", 200)
user3 = User("Kobe Bryant", 300)


# Chaining methods
user1.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawal(50).display_user_balance()

user2.make_deposit(50).make_withdrawal(25).display_user_balance()

user3.make_deposit(400).make_withdrawal(100).display_user_balance()


# Bonus
user1.transfer_money(user3, 100)

user1.display_user_balance()
user3.display_user_balance()