class User:
    def __init__(self, name, balance=0):
        self.name = name
        self.account_balance = balance

    def plus_money(self, amount):
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


# Create 3 users
user1 = User("Guido van Rossum", 100)
user2 = User("Michael Jordan", 200)
user3 = User("Kobe Bryant", 300)


# First user: 3 deposits, 1 withdrawal, display balance
user1.plus_money(50).plus_money(100).plus_money(25).make_withdrawal(75).display_user_balance()


# Second user: 2 deposits, 2 withdrawals, display balance
user2.plus_money(100).plus_money(50).make_withdrawal(80).make_withdrawal(30).display_user_balance()


# Third user: 1 deposit, 3 withdrawals, display balance
user3.plus_money(200).make_withdrawal(50).make_withdrawal(25).make_withdrawal(100).display_user_balance()


# BONUS: first user transfers money to third user
user1.transfer_money(user3, 50)

# Print both users' balances
user1.display_user_balance()
user3.display_user_balance()



#test with aws group activity



# class User:
#     def __init__(self,name,balance=0):
#         self.name=name 
#         self.hm=balance
#     def plus_money(self,num):
#         self.hm +=num
#         return self
#     def minus_money(self,num):
#         self.hm=self.hm-num
#         return self
#     def show_money(self):
#         print(f"name:{self.name} cash: ${self.hm}")
#         return self

# user1 = User("Guido van Rossum", 100)
# user2 = User("Michael Jordan", 200)
# user3 = User("Kobe Bryant", 300)

# user1.plus_money(50).plus_money(100).plus_money(25).show_money()
# user2.minus_money(50).plus_money(100).plus_money(25).minus_money(100).show_money()
# user3.plus_money(50).minus_money(100).minus_money(25).minus_money(5).show_money()


# # Print both users' balances
# user1.show_money()
# user2.show_money()
# user3.show_money()