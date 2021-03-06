select * from vendedor_java;
select * from empleado_java2;
select * from persona_java;
delete from persona_java;
delete from empleado_java2;
delete from vendedor_java;
delete from programador_java;
select * from programador_java;
commit;
create table direccion_java(
    cod_direccion number,
    nombre_via varchar2(25),
    num_via number,
    cod_postal number,
    CONSTRAINT PK_direccion_java PRIMARY KEY (cod_direccion)
);

commit;
create table oficina_java2(
    codigo number,
    nombre varchar2(25),
    direccion number,
    CONSTRAINT PK_oficina_java2 PRIMARY KEY (codigo),
    FOREIGN KEY (direccion) REFERENCES direccion_java(cod_direccion)
);

create table persona_java(
    dni varchar2(9) not null,
    nombre varchar2(25),
    ap1 varchar2(25),
    ap2 varchar(25),
    fecha_nac date,
    direccion number,
    CONSTRAINT PK_Persona_java PRIMARY KEY (dni),
    FOREIGN KEY (direccion) REFERENCES direccion_java(cod_direccion)
);

create table empleado_java2(
    dni varchar2(9) not null,
    fecha_alta date,
    oficina number,
    CONSTRAINT PK_empleado_java2 PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES persona_java(dni),
    FOREIGN KEY (oficina) REFERENCES oficina_java2(codigo)
);
drop table programador_java;
create table programador_java(
    dni varchar2(9) not null,
    tecnologias varchar2(300),
    CONSTRAINT PK_programador_java PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES empleado_java2(dni)
);

create table vendedor_java(
    dni varchar2(9) not null,
    zonas varchar2(25),
    CONSTRAINT PK_vendedor_java PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES empleado_java2(dni)
);



select p.dni, p.nombre, p.ap1, p.ap2, p.fecha_nac, p.direccion, e.oficina, v.zonas from persona_java p join empleado_java2 e on p.dni=e.dni join vendedor_java v on e.dni=v.dni where p.dni like upper ('77370255A');
