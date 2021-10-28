PRIVADA -> UN SOLO ROBOT DURANTE TODO EL PROGRAMA
PARCIALMENTE COMPARTIDA -> AL MENOS UN ROBOT NO ENTRA AL AREA ESA DURANTE EL PROGRAMA
COMPARTIDA -> TODOS LOS ROBOTS ENTRAN AL AREA AL MENOS UNA VEZ DURANTE EL PROGRAMA


EnviarMensaje(123,variable_robot_destino) -> envia el mensaje y sigue ejecutando las lineas de codigo (no se queda trabado)

RecibirMensaje(variable_donde_guarda_dato,variable_robot_origen) -> lo recibo del robot especifico
RecibirMensaje(variable_donde_guarda_dato,*) -> espero recibir mensaje de cualquier robot
-> hasta que no llega el mensaje, no puedo seguir ejecutando codigo


En el codigo tiene que haber la misma cantidad de recibir que de enviar 

Evitar que los robots se queden trabados en los RecibirMensaje


Cuando uso el RecibirMensaje con el * -> si solo hago un recibir con * no identeifico los robots
                                      -> para identificarlos: 
                                      
                                      ROBOT JUNTADOR (envia mensajes)
                                      1) Recibo mi identificador RecibirMensaje(id,JEFE)
                                      2) JUNTO FLORES
                                      3) mando el id del robot que quiere mandar el mensaje EnviarMensaje(id,robotJefe)
                                      4) le mando la cantidad de flores que junté EnviarMensaje(flores,robotJefe)

                                      ROBOT COORDINADOR/JEFE (recibe mensajes)
                                      1) identifico a los robots  -> le tengo que enviar el id correspondiente a cada robot
                                            EnviarMensaje(1,robot1)
                                            EnviarMensaje(2,robot2) ...

                                      2) recibo el id del robot RecibirMensaje(id,*)
                                      3) recibo el valor del robot que me lo quiere enviar RecibirMensaje(flores,id) (MAL)
                                                                                si id=1 -> RecibirMensaje(flores,robot1)  
                                                                                sino si id=2 -> RecibirMensaje(flores,robot2)   

EJEMPLO:

4 ROBOTS JUNTAN FLORES -> 1 solo tipo de robot porque hacen lo mismo
LE ENVIAN MENSAJES AL JEFE DICIENDO CUANTAS FLORES JUNTARON
Y EL JEFE TIENE QUE DECIR QUIEN JUNTO MAS FLORES.


ROBOT QUE JUNTA FLORES:
1) recibo mi identificador
2) junta las flores
3) mando id EnviarMensaje(id,robotJefe) //el id se recibio en el paso 1
4) mando las flores que junte

ROBOT JEFE:
1) mando identificadores a cada robot
2) recibo el id del que termino
3) identifica el robot que quiere mandar
4) recibo el dato
5) proceso dato






