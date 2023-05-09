import { Food } from "./Food";
import { User } from "./User";

export interface UserFood {
    user: User,
    food: Food
}