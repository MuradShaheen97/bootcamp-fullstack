from library_item import LibraryItem


class Book(LibraryItem):
    def __init__(self, title, item_id, author, pages):
        super().__init__(title, item_id)
        self.author = author
        self.pages = pages

    def calculate_late_fee(self, days_late):
        return days_late * 1