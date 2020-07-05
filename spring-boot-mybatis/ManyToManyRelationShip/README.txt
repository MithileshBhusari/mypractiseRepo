Since SQLite is an embedded database for C-like environments, written in C and thus compiled to native code,
changes that Hibernate (or any ORM) will support aren't really high.
Java is cross-platform and it would be a bit weird to have a platform-dependent dependency.
On Android, SQLite is used, but there the platform supplies a JDBC driver for it.

Usually, Windows binaries are compatible over different Windows versions - as long as the architecture stays the same.
If you look at the SQLite download page you'll notice there's a 32-bit pre-built Windows binary.
This one can be used on almost any Windows version (except Windows RT, maybe), but you cannot use it on Linux or OS X.
 In order to use SQLite from Java, you would need to include the correct binary for the specific OS / architecture,
 effectively making a Java application platform-dependent. That is something you usually don't want.

If you're building a desktop application in Swing and you want to use an embedded database,
my suggestion would be to use a Java embedded database, like H2, HSQL or Derby.
The latter is also shipped with Oracle Java as JavaDB.
All are supported as hibernate dialects
 (For a full list of dialects, see the dialect classes: https://github.com/hibernate/hibernate-orm/tree/master/hibernate-core/src/main/java/org/hibernate/dialect)

As noted below by @akostadinov, there may be other factors you want to consider, for example the fact that SQLite is written in native code and hence may have better performance. In the end, the only one who can decide which database is best is the one who is building the system.