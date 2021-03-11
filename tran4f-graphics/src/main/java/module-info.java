/**
 * <p>
 * 2021/2/15
 * </p>
 *
 * @author 王帅
 * @since 1.0
 */
open module tran4f.graphics {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.context;
    requires reactor.core;
    requires tran4f.core;
    requires org.yaml.snakeyaml;
    requires static lombok;
}