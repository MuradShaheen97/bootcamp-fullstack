from library_item import LibraryItem


class Magazine(LibraryItem):
    def __init__(self, title, item_id, issue_number, publisher):
        super().__init__(title, item_id)
        self.issue_number = issue_number
        self.publisher = publisher

    def calculate_late_fee(self, days_late):
        return days_late * 0.5