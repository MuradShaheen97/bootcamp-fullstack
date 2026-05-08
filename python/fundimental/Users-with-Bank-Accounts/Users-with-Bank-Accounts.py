class User:
# make the init values
    def __init__(self, name, balance=0):
        self.name = name
        self.account_balance = balance

# do the deposit  or the plus money for increasing in  bank account balance

    def plus_money(self, amount):
        self.account_balance += amount
        return self

# draw money from the bank account balalnce

    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self

# here to display the user balance

    def display_user_balance(self):
        print(f"User: {self.name}, Balance: ${self.account_balance}")
        return self

# here to transfer the amount from 2 users

    def transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
        return self


# Create 3 users
user1 = User("Guido van Rossum", 100)
user2 = User("Michael Jordan", 200)
user3 = User("Kobe Bryant", 300)

# these methods take space so we need to change them

# user1.plus_money(50)
# user1.plus_money(100)
# user1.plus_money(25)
# user1.make_withdrawal(75)
# user1.display_user_balance()


# user2.plus_money(100)
# user2.plus_money(50)
# user2.make_withdrawal(80)
# user2.make_withdrawal(30)
# user2.display_user_balance()


# user3.plus_money(200)
# user3.make_withdrawal(50)
# user3.make_withdrawal(25)
# user3.make_withdrawal(100)
# user3.display_user_balance()

#  insted of the prevoues one, it will be like this:-

# First user: 3 deposits, 1 withdrawal, display balance-------------------------------

user1.plus_money(50).plus_money(100).plus_money(25).make_withdrawal(75).display_user_balance()

# Second user: 2 deposits, 2 withdrawals, display balance------------------------------

user2.plus_money(100).plus_money(50).make_withdrawal(80).make_withdrawal(30).display_user_balance()

# Third user: 1 deposit, 3 withdrawals, display balance-------------------------------

user3.plus_money(200).make_withdrawal(50).make_withdrawal(25).make_withdrawal(100).display_user_balance()



# BONUS: first user transfers money to third user

user1.transfer_money(user3, 50)

# Print both users' balances
user1.display_user_balance()
user3.display_user_balance()


