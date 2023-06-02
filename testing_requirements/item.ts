interface Item {
  id: number;
  name: string;
  fillable: boolean;
  createdAt: string;
  description: string;
  tags: Tag;
}

interface Tag {
  id: number;
  attributes: Array<Attribute>;
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
