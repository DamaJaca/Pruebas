/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string;
        Integer num;
        Integer num2;
        Boolean funciona = true;
        Scanner entrada = new Scanner(System.in);

        ArrayList<Hoteles> hoteles = new ArrayList<>();
        hoteles.add(new Hoteles("Boomerang", 1100000));
        hoteles.add(new Hoteles("Chinatown", 2000000));
        hoteles.add(new Hoteles("President", 3000000));
        hoteles.add(new Hoteles("Waikiki", 4000000));
        hoteles.add(new Hoteles("Fontaine", 5000000));
        hoteles.add(new Hoteles("Blue", 6000000));

        System.out.println("Bienvenido a Hotel Medac. Introduce tu nombre de jugador.");
        string = entrada.next();
        Jugador jugador = new Jugador(string);

        for (int i = 0; i < 12; i++) {
            System.out.println("Estas en el turno [" + i + "] ¿Que quieres hacer? 1-Tirar dados 2-Pasar turno");
            System.out.println("Tu pasta: " + jugador.getDinero());
            num = entrada.nextInt();
            if (num == 1) {
                funciona=true;
                while (funciona) {
                    num = (1 + (int) (Math.random() * 6));
                    System.out.println("Has tirado un " + num + " y has caido en " + hoteles.get(num - 1).getName());
                    if (jugador.getHoteles() == null || !jugador.getHoteles().contains(hoteles.get(num-1))) {
                        num2 = (int) (Math.random() * 4);
                        System.out.println("Debes comprar el hotel, tiras el dado para comprar y sacas un " + num2);
                        switch (num2) {
                            case 0:
                                System.out.println("Enhorabuena, el hotel te sale gratis!!");
                                jugador.getHoteles().add(hoteles.get(num-1));
                                break;
                            case 1:
                                System.out.println("El hotel te sale a su precio real: " + hoteles.get(num-1).getPrecioCompra());
                                jugador.getHoteles().add(hoteles.get(num-1));
                                jugador.setDinero(jugador.getDinero() - hoteles.get(num-1).getPrecioCompra());
                                break;
                            case 2:
                                System.out.println("El hotel te sale al doble de su precio: " + (hoteles.get(num-1).getPrecioCompra() * 2));
                                jugador.getHoteles().add(hoteles.get(num-1));
                                jugador.setDinero(jugador.getDinero() - (hoteles.get(num-1).getPrecioCompra() * 2));
                                break;
                            case 3:
                                System.out.println("Se te impide comprar el hotel pero debes pagar su precio igualmente. Eres un desgraciado...");
                                jugador.setDinero(jugador.getDinero() - hoteles.get(num-1).getPrecioCompra());
                                break;
                        }
                        funciona = false;
                    } else {
                        System.out.println("Ya tienes ese hotel, prueba otra vez (perdiste 500.000)");
                        jugador.setDinero(jugador.getDinero() - 500000);
                    }
                }

            } else {
                jugador.setDinero(jugador.getDinero() + 500000);
            }
            if (jugador.getDinero() <= 0) {
                i = 30;
                System.out.println("Perdiste, te has quedado sin dinero bro...");
            } else {
                if (jugador.getHoteles().size() == hoteles.size()) {
                    System.out.println("Enhorabuena, consguiste todos los hoteles. Tu próximo paso es la casa blanca " + jugador.getName() + " Trump ;)");
                }
            }

        }
    }

}
