from library_item import LibraryItem


class DVD(LibraryItem):
    def __init__(self, title, item_id, duration, director):
        super().__init__(title, item_id)
        self.duration = duration
        self.director = director

    def calculate_late_fee(self, days_late):
        return days_late * 2