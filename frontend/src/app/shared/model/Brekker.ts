import { UserFood } from "./UserFood";

export interface Brekker{
    id?: number,
    data: Date,
    participants?: UserFood[]
}