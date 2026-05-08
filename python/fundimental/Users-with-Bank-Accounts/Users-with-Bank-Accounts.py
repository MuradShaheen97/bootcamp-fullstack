import sys
sys.path.append("../")

from bankAccount.BankAccount import BankAccount

class User:
    def __init__(self, name, balance=0, rate=0.01):
        self.name = name
        self.account = BankAccount(rate, balance)

    def plus_money(self, amount):
        self.account.deposit(amount)
        return self

    def make_withdrawal(self, amount):
        self.account.withdraw(amount)
        return self

    def display_user_balance(self):
        print(f"User: {self.name}, Balance: ${self.account.balance}")
        return self

    def transfer_money(self, other_user, amount):
        self.account.withdraw(amount)
        other_user.account.deposit(amount)
        return self


# Create users
user1 = User("Guido van Rossum", 100)
user2 = User("Michael Jordan", 200)
user3 = User("Kobe Bryant", 300)

# User 1
user1.plus_money(50).plus_money(100).plus_money(25).make_withdrawal(75).display_user_balance()

# User 2
user2.plus_money(100).plus_money(50).make_withdrawal(80).make_withdrawal(30).display_user_balance()

# User 3
user3.plus_money(200).make_withdrawal(50).make_withdrawal(25).make_withdrawal(100).display_user_balance()

# Transfer money
user1.transfer_money(user3, 50)

user1.display_user_balance()
user3.display_user_balance()