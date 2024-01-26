from django.db import models


class Actividadescronogramatecnicos(models.Model):
    idactividadcronogramatecnico = models.AutoField(db_column='idActividadCronogramaTecnico', primary_key=True)  # Field name made lowercase.
    nombreactividad = models.CharField(db_column='nombreActividad', max_length=30)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'actividadescronogramatecnicos'


class Administrador(models.Model):
    idadministrador = models.AutoField(db_column='idAdministrador', primary_key=True)  # Field name made lowercase.
    numerodocumento = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='numeroDocumento')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'administrador'


class Categoriasproductos(models.Model):
    idcategoriaproducto = models.AutoField(db_column='idCategoriaProducto', primary_key=True)  # Field name made lowercase.
    nombrecategoria = models.CharField(db_column='nombreCategoria', max_length=20)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'categoriasproductos'


class Categoriasservicios(models.Model):
    idcategoriaservicio = models.AutoField(db_column='idCategoriaServicio', primary_key=True)  # Field name made lowercase.
    nombrecategoria = models.CharField(db_column='nombreCategoria', max_length=30, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'categoriasservicios'


class Citas(models.Model):
    idcita = models.AutoField(db_column='idCita', primary_key=True)  # Field name made lowercase.
    fechacita = models.DateField(db_column='fechaCita')  # Field name made lowercase.
    direccioncita = models.CharField(db_column='direccionCita', max_length=50)  # Field name made lowercase.
    contactocliente = models.BigIntegerField(db_column='contactoCliente')  # Field name made lowercase.
    descripcioncita = models.TextField(db_column='descripcionCita')  # Field name made lowercase.
    idtecnico = models.ForeignKey('Tecnicos', models.DO_NOTHING, db_column='idTecnico', blank=True, null=True)  # Field name made lowercase.
    idadministrador = models.ForeignKey(Administrador, models.DO_NOTHING, db_column='idAdministrador', blank=True, null=True)  # Field name made lowercase.
    idcotizacion = models.ForeignKey('Cotizaciones', models.DO_NOTHING, db_column='idCotizacion', blank=True, null=True)  # Field name made lowercase.
    idestadocita = models.ForeignKey('Estadoscitas', models.DO_NOTHING, db_column='idEstadoCita', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'citas'


class Clientes(models.Model):
    idcliente = models.AutoField(db_column='idCliente', primary_key=True)  # Field name made lowercase.
    direccioncliente = models.CharField(db_column='direccionCliente', max_length=50)  # Field name made lowercase.
    numerodocumento = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='numeroDocumento')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'clientes'


class Cotizaciones(models.Model):
    idcotizacion = models.AutoField(db_column='idCotizacion', primary_key=True)  # Field name made lowercase.
    fechacotizacion = models.DateField(db_column='fechaCotizacion')  # Field name made lowercase.
    totalcotizacion = models.FloatField(db_column='totalCotizacion')  # Field name made lowercase.
    descripcioncotizacion = models.TextField(db_column='descripcionCotizacion')  # Field name made lowercase.
    idcliente = models.ForeignKey(Clientes, models.DO_NOTHING, db_column='idCliente')  # Field name made lowercase.
    idproducto = models.ForeignKey('Productos', models.DO_NOTHING, db_column='idProducto')  # Field name made lowercase.
    idservicio = models.ForeignKey('Servicios', models.DO_NOTHING, db_column='idServicio')  # Field name made lowercase.
    idestadocotizacion = models.ForeignKey('Estadoscotizaciones', models.DO_NOTHING, db_column='idEstadoCotizacion')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'cotizaciones'


class Cronogramatecnicos(models.Model):
    idcronogramatecnico = models.AutoField(db_column='idCronogramaTecnico', primary_key=True)  # Field name made lowercase.
    idtecnico = models.ForeignKey('Tecnicos', models.DO_NOTHING, db_column='idTecnico', blank=True, null=True)  # Field name made lowercase.
    idcita = models.ForeignKey(Citas, models.DO_NOTHING, db_column='idCita', blank=True, null=True)  # Field name made lowercase.
    iddisponibilidadcronograma = models.ForeignKey('Disponibilidadcronogramas', models.DO_NOTHING, db_column='idDisponibilidadCronograma', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'cronogramatecnicos'


class Detallesactividadcronograma(models.Model):
    iddetalleactividad = models.AutoField(db_column='idDetalleActividad', primary_key=True)  # Field name made lowercase.
    idcronogramatecnico = models.ForeignKey(Cronogramatecnicos, models.DO_NOTHING, db_column='idCronogramaTecnico', blank=True, null=True)  # Field name made lowercase.
    idactividadcronogramatecnico = models.ForeignKey(Actividadescronogramatecnicos, models.DO_NOTHING, db_column='idActividadCronogramaTecnico', blank=True, null=True)  # Field name made lowercase.
    fechaactividadcronograma = models.DateTimeField(db_column='fechaActividadCronograma')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'detallesactividadcronograma'


class Detallesventas(models.Model):
    iddetalleventa = models.AutoField(db_column='idDetalleVenta', primary_key=True)  # Field name made lowercase.
    detallesventa = models.CharField(db_column='detallesVenta', max_length=300)  # Field name made lowercase.
    subtotalventa = models.FloatField(db_column='subtotalVenta')  # Field name made lowercase.
    totalventa = models.FloatField(db_column='totalVenta')  # Field name made lowercase.
    idventa = models.ForeignKey('Ventas', models.DO_NOTHING, db_column='idVenta')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'detallesventas'


class Disponibilidadcronogramas(models.Model):
    iddisponibilidadcronograma = models.AutoField(db_column='idDisponibilidadCronograma', primary_key=True)  # Field name made lowercase.
    nombredisponibilidad = models.CharField(db_column='nombreDisponibilidad', max_length=30)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'disponibilidadcronogramas'


class Envios(models.Model):
    idenvio = models.AutoField(db_column='idEnvio', primary_key=True)  # Field name made lowercase.
    direccionenvio = models.CharField(db_column='direccionEnvio', max_length=50)  # Field name made lowercase.
    idtecnico = models.ForeignKey('Tecnicos', models.DO_NOTHING, db_column='idTecnico', blank=True, null=True)  # Field name made lowercase.
    idestadoenvio = models.ForeignKey('Estadosenvios', models.DO_NOTHING, db_column='idEstadoEnvio', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'envios'


class Enviosentregados(models.Model):
    idenvio = models.IntegerField(db_column='idEnvio', blank=True, null=True)  # Field name made lowercase.
    fecha = models.DateTimeField(blank=True, null=True)
    idtecnicoencargado = models.IntegerField(db_column='idTecnicoEncargado', blank=True, null=True)  # Field name made lowercase.
    documentotecnico = models.BigIntegerField(db_column='documentoTecnico', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'enviosentregados'


class Estadoscitas(models.Model):
    idestadocita = models.AutoField(db_column='idEstadoCita', primary_key=True)  # Field name made lowercase.
    nombreestadocita = models.CharField(db_column='nombreEstadoCita', max_length=20)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'estadoscitas'


class Estadoscotizaciones(models.Model):
    idestadocotizacion = models.AutoField(db_column='idEstadoCotizacion', primary_key=True)  # Field name made lowercase.
    nombreestadocotizacion = models.CharField(db_column='nombreEstadoCotizacion', max_length=20)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'estadoscotizaciones'


class Estadosenvios(models.Model):
    idestadoenvio = models.AutoField(db_column='idEstadoEnvio', primary_key=True)  # Field name made lowercase.
    nombreestadoenvio = models.CharField(db_column='nombreEstadoEnvio', max_length=20)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'estadosenvios'


class Estadospqrsf(models.Model):
    idestadopqrsf = models.AutoField(db_column='idEstadoPQRSF', primary_key=True)  # Field name made lowercase.
    nombreestadopqrsf = models.CharField(db_column='nombreEstadoPQRSF', max_length=20)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'estadospqrsf'


class Estadosusuarios(models.Model):
    idestadousuario = models.AutoField(db_column='idEstadoUsuario', primary_key=True)  # Field name made lowercase.
    nombreestadousuario = models.CharField(db_column='nombreEstadoUsuario', max_length=50)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'estadosusuarios'


class Permisos(models.Model):
    idpermiso = models.AutoField(db_column='idPermiso', primary_key=True)  # Field name made lowercase.
    nombrepermiso = models.CharField(db_column='nombrePermiso', max_length=20, blank=True, null=True)  # Field name made lowercase.
    idrol = models.ForeignKey('Roles', models.DO_NOTHING, db_column='idRol', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'permisos'


class Pqrsf(models.Model):
    idpqrsf = models.AutoField(db_column='idPQRSF', primary_key=True)  # Field name made lowercase.
    fechapqrsf = models.DateField(db_column='fechaPQRSF')  # Field name made lowercase.
    informacionpqrsf = models.TextField(db_column='informacionPQRSF')  # Field name made lowercase.
    idcliente = models.ForeignKey(Clientes, models.DO_NOTHING, db_column='idCliente')  # Field name made lowercase.
    idtipopqrsf = models.ForeignKey('Tipospqrsf', models.DO_NOTHING, db_column='idTipoPQRSF')  # Field name made lowercase.
    idestadopqrsf = models.ForeignKey(Estadospqrsf, models.DO_NOTHING, db_column='idEstadoPQRSF')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'pqrsf'


class Productos(models.Model):
    idproducto = models.AutoField(db_column='idProducto', primary_key=True)  # Field name made lowercase.
    nombreproducto = models.TextField(db_column='nombreProducto')  # Field name made lowercase.
    descripcionproducto = models.TextField(db_column='descripcionProducto')  # Field name made lowercase.
    precioproducto = models.FloatField(db_column='precioProducto')  # Field name made lowercase.
    cantidad = models.IntegerField()
    idadministrador = models.ForeignKey(Administrador, models.DO_NOTHING, db_column='idAdministrador', blank=True, null=True)  # Field name made lowercase.
    idcategoriaproducto = models.ForeignKey(Categoriasproductos, models.DO_NOTHING, db_column='idCategoriaProducto', blank=True, null=True)  # Field name made lowercase.
    idproveedorproducto = models.ForeignKey('Proveedoresproductos', models.DO_NOTHING, db_column='idProveedorProducto', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'productos'


class Proveedoresproductos(models.Model):
    idproveedorproducto = models.AutoField(db_column='idProveedorProducto', primary_key=True)  # Field name made lowercase.
    nombreproveedor = models.CharField(db_column='nombreProveedor', max_length=50)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'proveedoresproductos'


class Respuestas(models.Model):
    idrespuesta = models.AutoField(db_column='idRespuesta', primary_key=True)  # Field name made lowercase.
    fecha = models.DateField(blank=True, null=True)
    informacionrespuesta = models.TextField(db_column='informacionRespuesta', blank=True, null=True)  # Field name made lowercase.
    idadministrador = models.ForeignKey(Administrador, models.DO_NOTHING, db_column='idAdministrador', blank=True, null=True)  # Field name made lowercase.
    idpqrsf = models.ForeignKey(Pqrsf, models.DO_NOTHING, db_column='idPQRSF', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'respuestas'


class Roles(models.Model):
    idrol = models.AutoField(db_column='idRol', primary_key=True)  # Field name made lowercase.
    nombrerol = models.CharField(db_column='nombreRol', max_length=20, blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'roles'


class RolesHasPermisos(models.Model):
    idrol = models.ForeignKey(Roles, models.DO_NOTHING, db_column='idRol', blank=True, null=True)  # Field name made lowercase.
    idpermiso = models.ForeignKey(Permisos, models.DO_NOTHING, db_column='idPermiso', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'roles_has_permisos'


class Servicios(models.Model):
    idservicio = models.AutoField(db_column='idServicio', primary_key=True)  # Field name made lowercase.
    nombreservicio = models.TextField(db_column='nombreServicio')  # Field name made lowercase.
    descripcionservicio = models.TextField(db_column='descripcionServicio')  # Field name made lowercase.
    idcategoriaservicio = models.ForeignKey(Categoriasservicios, models.DO_NOTHING, db_column='idCategoriaServicio', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'servicios'


class Tecnicos(models.Model):
    idtecnico = models.AutoField(db_column='idTecnico', primary_key=True)  # Field name made lowercase.
    especialidad = models.CharField(max_length=50)
    numerodocumento = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='numeroDocumento')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'tecnicos'


class Tipospqrsf(models.Model):
    idtipopqrsf = models.AutoField(db_column='idTipoPQRSF', primary_key=True)  # Field name made lowercase.
    nombretipopqrsf = models.CharField(db_column='nombreTipoPQRSF', max_length=20)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'tipospqrsf'


class Usuarios(models.Model):
    numerodocumento = models.BigIntegerField(db_column='numeroDocumento', primary_key=True)  # Field name made lowercase.
    nombre = models.CharField(max_length=50, blank=True, null=True)
    apellido = models.CharField(max_length=50, blank=True, null=True)
    email = models.CharField(max_length=120, blank=True, null=True)
    password = models.CharField(max_length=100, blank=True, null=True)
    numerocontacto = models.FloatField(db_column='numeroContacto', blank=True, null=True)  # Field name made lowercase.
    idrol = models.ForeignKey(Roles, models.DO_NOTHING, db_column='idRol')  # Field name made lowercase.
    idestadosusuarios = models.ForeignKey(Estadosusuarios, models.DO_NOTHING, db_column='idEstadosUsuarios')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'usuarios'


class Ventas(models.Model):
    idventa = models.AutoField(db_column='idVenta', primary_key=True)  # Field name made lowercase.
    fechaventa = models.DateField(db_column='fechaVenta')  # Field name made lowercase.
    idenvio = models.ForeignKey(Envios, models.DO_NOTHING, db_column='idEnvio')  # Field name made lowercase.
    idcotizacion = models.ForeignKey(Cotizaciones, models.DO_NOTHING, db_column='idCotizacion')  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'ventas'
