interface AttributeType {
  id: number;
  name: string;
}

interface Attribute {
  id: number;
  name: string;
  type: AttributeType;
}

interface Tag {
  id: number;
  name: string;
  attributes: Attribute[];
}
