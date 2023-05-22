import { defineStore } from "pinia";
import { Entry } from "../domain/fetchTree";

interface State {
  selectedEntry: Entry | undefined;
}

export const selectedItemEntryStore = defineStore("selectedUserEntryStrore", {
  state: (): State => {
    return { selectedEntry: undefined };
  },
  actions: {
    set(entry: Entry) {
      console.log(`Store set: ${entry?.item.name}`);
      this.selectedEntry = entry;
    },
  },
  getters: {
    getEntry(): Entry | undefined {
      return this.selectedEntry;
    },
  },
});
