class Product {
  id;
  name;
  price;
  stockQuantity;

  constructor(id, name, price, stockQuantity) {
    if (new.target === Product) {
      throw new Error("Cannot instantiate abstract class Product");
    }

    this.setId(id);
    this.setName(name);
    this.setPrice(price);
    this.setStockQuantity(stockQuantity);
  }

  setId(id) {
    this.#id = id;
  }

  getId() {
    return this.#id;
  }

  setName(name) {
    this.#name = name;
  }

  getName() {
    return this.#name;
  }

  // Price (with validation)
  setPrice(price) {
    if (typeof price !== "number" || price < 0) {
      throw new Error("Price must be a positive number");
    }
    this.#price = price;
  }

  getPrice() {
    return this.#price;
  }

  // Stock Quantity (with validation)
  setStockQuantity(quantity) {
    if (!Number.isInteger(quantity) || quantity < 0) {
      throw new Error("Stock quantity must be a non-negative integer");
    }
    this.#stockQuantity = quantity;
  }

  getStockQuantity() {
    return this.#stockQuantity;
  }

  // Abstract method simulation
  getDetails() {
    throw new Error("Abstract method 'getDetails' must be implemented");
  }
}

class ElectronicsProduct extends Product {
  #brand;
  #warrantyMonths;

  constructor(id, name, price, stockQuantity, brand, warrantyMonths) {
    super(id, name, price, stockQuantity);
    this.setBrand(brand);
    this.setWarrantyMonths(warrantyMonths);
  }

  setBrand(brand) {
    this.#brand = brand;
  }

  getBrand() {
    return this.#brand;
  }

  setWarrantyMonths(months) {
    if (!Number.isInteger(months) || months < 0) {
      throw new Error("Warranty months must be a non-negative integer");
    }
    this.#warrantyMonths = months;
  }

  getWarrantyMonths() {
    return this.#warrantyMonths;
  }

  getDetails() {
    return `${this.getName()} (Electronics) - Brand: ${this.getBrand()}, Warranty: ${this.getWarrantyMonths()} months`;
  }
}

class ClothingProduct extends Product {
  #size;
  #material;

  constructor(id, name, price, stockQuantity, size, material) {
    super(id, name, price, stockQuantity);
    this.setSize(size);
    this.setMaterial(material);
  }

  setSize(size) {
    this.#size = size;
  }

  getSize() {
    return this.#size;
  }

  setMaterial(material) {
    this.#material = material;
  }

  getMaterial() {
    return this.#material;
  }

  getDetails() {
    return `${this.getName()} (Clothing) - Size: ${this.getSize()}, Material: ${this.getMaterial()}`;
  }
}
