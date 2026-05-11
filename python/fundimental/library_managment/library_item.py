from abc import ABC, abstractmethod


class LibraryItem(ABC):
    def __init__(self, title, item_id):
        self.title = title
        self.item_id = item_id
        self.is_borrowed = False

    def borrow_item(self):
        if self.is_borrowed:
            print(f"{self.title} is already borrowed.")
        else:
            self.is_borrowed = True
            print(f"{self.title} has been borrowed.")

    def return_item(self):
        if self.is_borrowed:
            self.is_borrowed = False
            print(f"{self.title} has been returned.")
        else:
            print(f"{self.title} was not borrowed.")

    def check_availability(self):
        if self.is_borrowed:
            return "Not available"
        return "Available"

    def notify_overdue(self, days_late):
        if days_late > 0:
            print(f"Notification: {self.title} is overdue by {days_late} days.")

    @abstractmethod
    def calculate_late_fee(self, days_late):
        pass