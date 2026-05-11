from book import Book
from magazine import Magazine
from dvd import DVD


book1 = Book("Python Basics", 101, "John Smith", 300)
magazine1 = Magazine("Tech Monthly", 201, 45, "Tech Publisher")
dvd1 = DVD("OOP Tutorial", 301, 120, "Mark Lee")


book1.borrow_item()
print(book1.check_availability())
book1.notify_overdue(3)
print("Late fee:", book1.calculate_late_fee(3), "$")
book1.return_item()

print()

magazine1.borrow_item()
magazine1.notify_overdue(4)
print("Late fee:", magazine1.calculate_late_fee(4), "$")

print()

dvd1.borrow_item()
dvd1.notify_overdue(2)
print("Late fee:", dvd1.calculate_late_fee(2), "$")