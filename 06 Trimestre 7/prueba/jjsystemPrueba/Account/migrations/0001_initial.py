# Generated by Django 5.0.1 on 2024-03-14 20:33

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Actividadescronogramatecnicos',
            fields=[
                ('idactividadcronogramatecnico', models.AutoField(db_column='idActividadCronogramaTecnico', primary_key=True, serialize=False)),
                ('nombreactividad', models.CharField(db_column='nombreActividad', max_length=30)),
            ],
            options={
                'db_table': 'actividadescronogramatecnicos',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Administrador',
            fields=[
                ('idadministrador', models.AutoField(db_column='idAdministrador', primary_key=True, serialize=False)),
            ],
            options={
                'db_table': 'administrador',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Categoriasproductos',
            fields=[
                ('idcategoriaproducto', models.AutoField(db_column='idCategoriaProducto', primary_key=True, serialize=False)),
                ('nombrecategoria', models.CharField(db_column='nombreCategoria', max_length=20)),
            ],
            options={
                'db_table': 'categoriasproductos',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Categoriasservicios',
            fields=[
                ('idcategoriaservicio', models.AutoField(db_column='idCategoriaServicio', primary_key=True, serialize=False)),
                ('nombrecategoria', models.CharField(blank=True, db_column='nombreCategoria', max_length=30, null=True)),
            ],
            options={
                'db_table': 'categoriasservicios',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Citas',
            fields=[
                ('idcita', models.AutoField(db_column='idCita', primary_key=True, serialize=False)),
                ('fechacita', models.DateField(db_column='fechaCita')),
                ('direccioncita', models.CharField(db_column='direccionCita', max_length=50)),
                ('contactocliente', models.BigIntegerField(db_column='contactoCliente')),
                ('descripcioncita', models.TextField(db_column='descripcionCita')),
            ],
            options={
                'db_table': 'citas',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Clientes',
            fields=[
                ('idcliente', models.AutoField(db_column='idCliente', primary_key=True, serialize=False)),
                ('direccioncliente', models.CharField(db_column='direccionCliente', max_length=50)),
            ],
            options={
                'db_table': 'clientes',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Cotizaciones',
            fields=[
                ('idcotizacion', models.AutoField(db_column='idCotizacion', primary_key=True, serialize=False)),
                ('fechacotizacion', models.DateField(db_column='fechaCotizacion')),
                ('totalcotizacion', models.FloatField(db_column='totalCotizacion')),
                ('descripcioncotizacion', models.TextField(db_column='descripcionCotizacion')),
            ],
            options={
                'db_table': 'cotizaciones',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Cronogramatecnicos',
            fields=[
                ('idcronogramatecnico', models.AutoField(db_column='idCronogramaTecnico', primary_key=True, serialize=False)),
            ],
            options={
                'db_table': 'cronogramatecnicos',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Detallesactividadcronograma',
            fields=[
                ('iddetalleactividad', models.AutoField(db_column='idDetalleActividad', primary_key=True, serialize=False)),
                ('fechaactividadcronograma', models.DateTimeField(db_column='fechaActividadCronograma')),
            ],
            options={
                'db_table': 'detallesactividadcronograma',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DetallesEnviosVentas',
            fields=[
                ('idenvio', models.IntegerField(primary_key=True, serialize=False)),
                ('direccionenvio', models.CharField(max_length=255)),
                ('detallesventa', models.CharField(max_length=255)),
                ('tecnicoasignado', models.IntegerField()),
                ('numerodocumento', models.CharField(max_length=255)),
                ('fechaventa', models.DateField()),
            ],
            options={
                'db_table': 'detalle_envios_ventas',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Detallesventas',
            fields=[
                ('iddetalleventa', models.AutoField(db_column='idDetalleVenta', primary_key=True, serialize=False)),
                ('detallesventa', models.CharField(db_column='detallesVenta', max_length=300)),
                ('subtotalventa', models.FloatField(db_column='subtotalVenta')),
                ('totalventa', models.FloatField(db_column='totalVenta')),
            ],
            options={
                'db_table': 'detallesventas',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Disponibilidadcronogramas',
            fields=[
                ('iddisponibilidadcronograma', models.AutoField(db_column='idDisponibilidadCronograma', primary_key=True, serialize=False)),
                ('nombredisponibilidad', models.CharField(db_column='nombreDisponibilidad', max_length=30)),
            ],
            options={
                'db_table': 'disponibilidadcronogramas',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DjangoContentType',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('app_label', models.CharField(max_length=100)),
                ('model', models.CharField(max_length=100)),
            ],
            options={
                'db_table': 'django_content_type',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DjangoMigrations',
            fields=[
                ('id', models.BigAutoField(primary_key=True, serialize=False)),
                ('app', models.CharField(max_length=255)),
                ('name', models.CharField(max_length=255)),
                ('applied', models.DateTimeField()),
            ],
            options={
                'db_table': 'django_migrations',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DjangoSession',
            fields=[
                ('session_key', models.CharField(max_length=40, primary_key=True, serialize=False)),
                ('session_data', models.TextField()),
                ('expire_date', models.DateTimeField()),
            ],
            options={
                'db_table': 'django_session',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Envios',
            fields=[
                ('idenvio', models.AutoField(db_column='idEnvio', primary_key=True, serialize=False)),
                ('direccionenvio', models.CharField(db_column='direccionEnvio', max_length=50)),
            ],
            options={
                'db_table': 'envios',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Enviosentregados',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('idenvio', models.IntegerField(blank=True, db_column='idEnvio', null=True)),
                ('fecha', models.DateTimeField(blank=True, null=True)),
                ('idtecnicoencargado', models.IntegerField(blank=True, db_column='idTecnicoEncargado', null=True)),
                ('documentotecnico', models.BigIntegerField(blank=True, db_column='documentoTecnico', null=True)),
            ],
            options={
                'db_table': 'enviosentregados',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Estadoscitas',
            fields=[
                ('idestadocita', models.AutoField(db_column='idEstadoCita', primary_key=True, serialize=False)),
                ('nombreestadocita', models.CharField(db_column='nombreEstadoCita', max_length=20)),
            ],
            options={
                'db_table': 'estadoscitas',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Estadoscotizaciones',
            fields=[
                ('idestadocotizacion', models.AutoField(db_column='idEstadoCotizacion', primary_key=True, serialize=False)),
                ('nombreestadocotizacion', models.CharField(db_column='nombreEstadoCotizacion', max_length=20)),
            ],
            options={
                'db_table': 'estadoscotizaciones',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Estadosenvios',
            fields=[
                ('idestadoenvio', models.AutoField(db_column='idEstadoEnvio', primary_key=True, serialize=False)),
                ('nombreestadoenvio', models.CharField(db_column='nombreEstadoEnvio', max_length=20)),
            ],
            options={
                'db_table': 'estadosenvios',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Estadospqrsf',
            fields=[
                ('idestadopqrsf', models.AutoField(db_column='idEstadoPQRSF', primary_key=True, serialize=False)),
                ('nombreestadopqrsf', models.CharField(db_column='nombreEstadoPQRSF', max_length=20)),
            ],
            options={
                'db_table': 'estadospqrsf',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Estadosusuarios',
            fields=[
                ('idestadousuario', models.AutoField(db_column='idEstadoUsuario', primary_key=True, serialize=False)),
                ('nombreestadousuario', models.CharField(db_column='nombreEstadoUsuario', max_length=50)),
            ],
            options={
                'db_table': 'estadosusuarios',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Permisos',
            fields=[
                ('idpermiso', models.AutoField(db_column='idPermiso', primary_key=True, serialize=False)),
                ('nombrepermiso', models.CharField(blank=True, db_column='nombrePermiso', max_length=20, null=True)),
            ],
            options={
                'db_table': 'permisos',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Pqrsf',
            fields=[
                ('idpqrsf', models.AutoField(db_column='idPQRSF', primary_key=True, serialize=False)),
                ('fechapqrsf', models.DateField(db_column='fechaPQRSF')),
                ('informacionpqrsf', models.TextField(db_column='informacionPQRSF')),
            ],
            options={
                'db_table': 'pqrsf',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Productos',
            fields=[
                ('idproducto', models.AutoField(db_column='idProducto', primary_key=True, serialize=False)),
                ('nombreproducto', models.TextField(db_column='nombreProducto')),
                ('descripcionproducto', models.TextField(db_column='descripcionProducto')),
                ('precioproducto', models.FloatField(db_column='precioProducto')),
                ('cantidad', models.IntegerField()),
            ],
            options={
                'db_table': 'productos',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Proveedoresproductos',
            fields=[
                ('idproveedorproducto', models.AutoField(db_column='idProveedorProducto', primary_key=True, serialize=False)),
                ('nombreproveedor', models.CharField(db_column='nombreProveedor', max_length=50)),
            ],
            options={
                'db_table': 'proveedoresproductos',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Respuestas',
            fields=[
                ('idrespuesta', models.AutoField(db_column='idRespuesta', primary_key=True, serialize=False)),
                ('fecha', models.DateField(blank=True, null=True)),
                ('informacionrespuesta', models.TextField(blank=True, db_column='informacionRespuesta', null=True)),
            ],
            options={
                'db_table': 'respuestas',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Roles',
            fields=[
                ('idrol', models.AutoField(db_column='idRol', primary_key=True, serialize=False)),
                ('nombrerol', models.CharField(blank=True, db_column='nombreRol', max_length=20, null=True)),
            ],
            options={
                'db_table': 'roles',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='RolesHasPermisos',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
            ],
            options={
                'db_table': 'roles_has_permisos',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Servicios',
            fields=[
                ('idservicio', models.AutoField(db_column='idServicio', primary_key=True, serialize=False)),
                ('nombreservicio', models.TextField(db_column='nombreServicio')),
                ('descripcionservicio', models.TextField(db_column='descripcionServicio')),
            ],
            options={
                'db_table': 'servicios',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Tecnicos',
            fields=[
                ('idtecnico', models.AutoField(db_column='idTecnico', primary_key=True, serialize=False)),
                ('especialidad', models.CharField(max_length=50)),
            ],
            options={
                'db_table': 'tecnicos',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Tipospqrsf',
            fields=[
                ('idtipopqrsf', models.AutoField(db_column='idTipoPQRSF', primary_key=True, serialize=False)),
                ('nombretipopqrsf', models.CharField(db_column='nombreTipoPQRSF', max_length=20)),
            ],
            options={
                'db_table': 'tipospqrsf',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Usuarios',
            fields=[
                ('numerodocumento', models.BigIntegerField(db_column='numeroDocumento', primary_key=True, serialize=False)),
                ('nombre', models.CharField(blank=True, max_length=50, null=True)),
                ('apellido', models.CharField(blank=True, max_length=50, null=True)),
                ('email', models.EmailField(blank=True, max_length=120, null=True)),
                ('password', models.CharField(blank=True, max_length=100, null=True)),
                ('numerocontacto', models.FloatField(blank=True, db_column='numeroContacto', null=True)),
                ('last_login', models.DateTimeField(blank=True, null=True)),
            ],
            options={
                'db_table': 'usuarios',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Ventas',
            fields=[
                ('idventa', models.AutoField(db_column='idVenta', primary_key=True, serialize=False)),
                ('fechaventa', models.DateField(db_column='fechaVenta')),
            ],
            options={
                'db_table': 'ventas',
                'managed': False,
            },
        ),
    ]
