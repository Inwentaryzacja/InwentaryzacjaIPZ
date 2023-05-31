interface Child {
  entry: Entry;
  children: Child[];
}

interface Entry {
  id: number;
  item: Item;
  parent: Entry;
  addedAt: string;
  quantity: number;
  userId: number;
  attributeValues: AttributeValue[];
}

interface Item {
  id: number;
  name: string;
  fillable: boolean;
  createdAt: string;
  description: string;
}

interface AttributeValue {
  id: number;
  attribute: Attribute;
  value: Object;
}

interface Attribute {
  id: number;
  name: string;
  type: AttributeType;
}

interface AttributeType {
  id: number;
  name: string;
}
