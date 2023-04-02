# rest
Proyecto para crear la cuenta y registrar sus movimientos (depósito y retiros).

TECNOLOGÍAS UTILIZADAS
Para el desarrollo de la solución se utilizó el Spring boot (framework de java), JDK 17.0, Apache Maven 3.9.1, IntelliJ IDEA para el código Java, MySQL Workbench y PostMan para las pruebas.
Inicialmente se creó el API rest con Start.spring.io (Springboot), incluyendo las siguientes dependencias:
  - Spring Web
  - Mysql driver
  - Spring data JPA

SOLUCIÓN:
Se creó una base de datos “principal” en Mysql, que consiste en las siguientes tablas:
  - Cuenta, con las siguientes columnas
	ID - valor autoincrementable
	CUENTA - cuenta cliente asignado
	MONEDA - moneda de la cuenta 0:BS, 1:USD
	NOMBRE_CUENTA - nombre de la cuenta cliente
	ESTADO - estado de la cuenta ACTIVE, HOLD
	SALDO_ANT - valor del saldo anterior
	SALDO - valor del saldo actual de la cuenta

  - Movimiento, con las siguientes columnas
	ID - identificador del registro auto incrementable,
	CUENTA - número de cuenta (Campo CUENTA de la tabla Cuenta),
	TIPO - especifica si se trata de débito (D) o crédito (C)
	ESTADO - indica si la transacción fue correcta (N) o rechazada (R),
	MONEDA_MTO - moneda del depósito o retiro 0: Bs, 1: USD
	VALOR_ANT decimal(18,2),
	VALOR valor del movimiento

La relación de ambas tablas es a través de la cuenta cliente.
En las clases principales se encuentra un breve comentario sobre el funcionamiento.



