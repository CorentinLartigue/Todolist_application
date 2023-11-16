import {Statut} from "./Statut";
import {Timestamp} from "rxjs";

export interface Todo {
  id: Number,
  nom: String,
  statut: Statut,
  contenu:String,
  date_creation:Timestamp<any>;


}
