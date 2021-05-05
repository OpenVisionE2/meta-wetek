SUMMARY = "libgles for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "virtual/libgles1 virtual/libgles2 virtual/egl"

COMPATIBLE_MACHINE = "(wetekplay2|wetekhub)"

SRC_URI = "http://sources.libreelec.tv/devel/opengl-meson-gxbb-r6p1-01rel0.tar.xz \
	file://10-meson_mali.rules \
	" 

SRC_URI[md5sum] = "90ef0a79c37ba65f2c1b992a9bba2874"

S = "${WORKDIR}/opengl-meson-gxbb-r6p1-01rel0/usr"

INHIBIT_PACKAGE_STRIP = "1"

do_compile() {
}

do_install() {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -d ${D}${includedir}
	install -d ${D}${libdir}
	install -m 0644 ${WORKDIR}/10-meson_mali.rules  ${D}${sysconfdir}/udev/rules.d/
	cp -axr ${S}/include/* ${D}${includedir}/
	cp -ax ${S}/lib/* ${D}${libdir}/
}

do_package_qa() {
}

FILES_${PN} = "${includedir}/* ${libdir}/*  ${sysconfdir}/*"
FILES_${PN}-dev = "${incdir}/*"
