export async function get(): Promise<Child> {
  const response = await fetch("http://localhost:8080/inventory_entries/user/1/tree");
  // const response = await fetch("http://localhost:4545/roles");

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
}

export interface Item {
  name: string;
  fillable: boolean;
  createdAt: string;
  description: string;
}
