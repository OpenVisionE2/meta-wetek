require conf/license/license-gplv2.inc


SRC_URI = " file://wetek-shutdown.sh"

S = "${WORKDIR}"

INITSCRIPT_NAME = "wetek-shutdown"
INITSCRIPT_PARAMS = "start 39 0 ."

inherit pkgconfig update-rc.d

do_install() {
    install -d ${D}${INIT_D_DIR}/
    install -m 0755 ${WORKDIR}/wetek-shutdown.sh ${D}${INIT_D_DIR}/wetek-shutdown
}

COMPATIBLE_MACHINE = "^(wetekplay|wetekplay2|wetekhub)$"
