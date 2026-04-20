class User {
  // 🔒 private properties
  private  firstName: string; 
  private lastName: string;
  private address: string;
  private phoneNumber: number;

  // 🏗 constructor
  constructor(
    firstName: string,
    lastName: string,
    address: string,
    phoneNumber: number,
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  // 👀 Getter (READ)
  public getFirstName(): string {
    return this.firstName;
  }

  public getLastName(): string {
    return this.lastName;
  }

  public getAddress(): string {
    return this.address;
  }

  public getPhoneNumber(): number {
    return this.phoneNumber;
  }

  //  Setter (WRITE with control)
   public setFirstName(name: string): void {
    this.firstName = name;
  }
  public setLastName(name: string): void {
    this.lastName = name;
  }

  public setAddress(address: string): void {
    this.address = address;
  }

  public setPhoneNumber(phone: number): void {
    this.phoneNumber = phone;
  }
}



// Create object
const user1 = new User(
  "Murad",
  "Shaheen",
  "Ramallah",
  0591234567,
);

// ===============================
// READ DATA
// ===============================
console.log("=== BEFORE UPDATE ===");

console.log("First Name:", user1.getFirstName());
console.log("Last Name:", user1.getLastName());
console.log("Address:", user1.getAddress());
console.log("Phone:", user1.getPhoneNumber());

// ===============================
// UPDATE DATA
// ===============================
console.log("\n=== TRY UPDATE ===");

user1.setLastName("david"); // works

user1.setPhoneNumber("123"); //  invalid

user1.setPhoneNumber(56878787); 
user1.setAddress("Jerusalem");


console.log("\n=== AFTER UPDATE ===");

console.log("First Name:", user1.getFirstName()); 
console.log("Last Name:", user1.getLastName());
console.log("Address:", user1.getAddress());
console.log("Phone:", user1.getPhoneNumber());
