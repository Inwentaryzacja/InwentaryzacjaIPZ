export default async function get() {
    const response = await fetch("http://localhost:8080/inventory_entries/user/1/tree");
    const jsonData = await response.json();
    return jsonData;
}