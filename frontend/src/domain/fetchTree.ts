export async function get(): Promise<Child> {
  const response = await fetch("http://localhost:8080/inventory_entries/user/1/tree");
  // const response = await fetch("http://localhost:8080/inventory_entries/user/1/tree");

  console.log(response);
  const jsonData = await response.json();
  console.log(jsonData);
  return jsonData;
}

export interface Child {
  entry: Entry;
  children: Child[];
}

export interface Entry {
  id: number;
  item: Item;
  parent: Entry;
  addedAt: string;
  quantity: number;
  userId: number;
  attributeValues: AttributeValue[];
}

export interface Item {
  name: string;
  fillable: boolean;
  createdAt: string;
  description: string;
}

export interface AttributeValue {
  attribute: AttributeType;
  value: Object
}

export interface  AttributeType {
  name: string;
  type: { name: string }
}