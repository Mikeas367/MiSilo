import type { DetallePedido } from "./DetallePedido";

export interface Pedido{
    id: number,
    detallePedidos: DetallePedido[],
    fechaPedido: Date,
    totalKilos: number
    
}
