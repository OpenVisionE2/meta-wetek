SUMMARY = "libgles for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "virtual/libgles1 virtual/libgles2 virtual/egl"

COMPATIBLE_MACHINE = "(wetekplay)"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/amlogic-libs/master/opengl-meson6-r4p1-armhf.tgz \
	file://10-meson_mali.rules \
	" 

SRC_URI[md5sum] = "c833d32411389cba490bdaaa43263ba9"
SRC_URI[sha256sum] = "add5a65af74ca4db862f114fd7a8498aee6e62a3f92916f508259cb8163ea296"

S = "${WORKDIR}/usr"

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
