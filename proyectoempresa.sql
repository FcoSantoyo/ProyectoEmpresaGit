drop table direccion_pg;
create table direccion_pg(
    codigo_calle number,
    tipo_via varchar(20),
    nombre_via varchar2(20),
    numero number,
    localidad varchar(20),
    provincia varchar2(20)

    CONSTRAINT PK_direccion_pg PRIMARY KEY (codigo_calle)
);

drop table oficina_pg;
create table oficina_pg(
    nombre varchar2(25),
    codigo number,
    direccion varchar2(25),

    CONSTRAINT PK_oficina_pg PRIMARY KEY (nombre),
    FOREIGN KEY (direccion) REFERENCES direccion_pg(nombre_via)
);

drop table persona_pg;
create table persona_pg(
    dni varchar2(9) not null,
    nombre varchar2(25),
    ap1 varchar2(25),
    ap2 varchar(25),
    f_nac date,
    direccion varchar2(25),

    CONSTRAINT PK_Persona PRIMARY KEY (dni),
    FOREIGN KEY (direccion) REFERENCES direccion_pg(nombre_via)
);

drop table empleado_pg;
create table empleado_pg(
    dni varchar2(25) not null,
    f_alta date,
    oficina varchar2(25),

    FOREIGN KEY (dni) REFERENCES persona_pg(dni),
    FOREIGN KEY (oficina) REFERENCES oficina_pg(nombre)

);

ALTER TABLE empleado_pg ADD CONSTRAINT empleado_pg_PK PRIMARY KEY (dni);


create table programador_pg(
    dni varchar2(25) not null,
    tecnologias varchar2(90),

    FOREIGN KEY (dni) REFERENCES persona_pg(dni)
);

ALTER TABLE programador_pg ADD CONSTRAINT empleado_pg PRIMARY KEY (dni);

create table vendedor_pg(
    dni varchar2(25) not null,
    zonas varchar2(25),

    FOREIGN KEY (dni) REFERENCES persona_pg(dni)
);

ALTER TABLE vendedor_pg ADD CONSTRAINT vendedor_pg PRIMARY KEY (dni);