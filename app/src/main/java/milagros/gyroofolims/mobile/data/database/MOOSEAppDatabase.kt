package milagros.gyroofolims.mobile.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import milagros.gyroofolims.mobile.data.database.converter.Converters
import milagros.gyroofolims.mobile.data.database.dao.HighScoreDao
import milagros.gyroofolims.mobile.data.entity.HighScore

@Database(
    entities = [HighScore::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MOOSEAppDatabase : RoomDatabase() {

    abstract fun highScoreDao(): HighScoreDao
}
